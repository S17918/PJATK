using APBD_CW3.Services.Responses;
using APBD_CW3.Services.Requests;
using System;
using System.Data;
using System.Data.SqlClient;
using APBD_CW3.Models;

namespace APBD_CW3.Services
{
    public class StudentService : IStudentsDbService
    {
        private const string Connection = "Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True";

        public StudentResults EnrollStudent(EnrollStudentReq model)
        {
            StudentResults result = new StudentResults
            {
                Success = true,
                Message = string.Empty
            };

            using (var connect = new SqlConnection(Connection))
            using (var sqlCommand = new SqlCommand())
            {
                sqlCommand.Connection = connect;
                connect.Open();
                var transaction = connect.BeginTransaction();

                try
                {
                    sqlCommand.CommandText = "Select TOP(1) IdStudies from Studies where Name=@name";
                    sqlCommand.Parameters.AddWithValue("name", model.Studies);

                    var reader = sqlCommand.ExecuteReader();
                    if (!reader.Read())
                    {
                        transaction.Rollback();
                        result.Message = "No such studies";
                        result.Success = false;
                        return result;
                    }

                    int idStudies = (int)reader["IdStudies"];
                    reader.Close();
                    sqlCommand.Parameters.Clear();
                    sqlCommand.CommandText = "select TOP(1) IdEnrollment, StartDate from Enrollment where IdStudy=@idStudy and semester=1";
                    sqlCommand.Parameters.AddWithValue("idStudy", idStudies);

                    int idEnrollment;
                    DateTime Start;

                    if (!reader.Read())
                    {
                        reader.Close();
                        sqlCommand.Parameters.Clear();
                        Start = DateTime.Now;
                        sqlCommand.CommandText = "Insert into Enrollment (Semester, IdStudy, StartDate) " + "values 1, @idStudy, @dateNow; SELECT SCOPE_IDENTITY()";
                        sqlCommand.Parameters.AddWithValue("dateNow", Start);
                        sqlCommand.Parameters.AddWithValue("idStudy", idStudies);
                        idEnrollment = (int)sqlCommand.ExecuteScalar();
                        sqlCommand.Parameters.Clear();
                    }
                    else
                    {
                        idEnrollment = (int)reader["IdEnrollment"];
                        Start = (DateTime)reader["StartDate"];
                    }

                    sqlCommand.CommandText = "select TOP(1) IndexNumber from Student where IndexNumber=@indexNumber";
                    sqlCommand.Parameters.AddWithValue("indexNumber", model.IndexNumber);
                    reader = sqlCommand.ExecuteReader();

                    if (!reader.Read())
                    {
                        transaction.Rollback();
                        result.Message = "No such student";
                        result.Success = false;
                        return result;
                    }
                    reader.Close();
                    sqlCommand.Parameters.Clear();

                    sqlCommand.CommandText = "INSERT INTO Student (IndexNumber, FirstName, LastName, BirthDate, IdEnrollment) " + " VALUES @indexNumber, @firstName, @lastName, @birthDate, @idEnrollment " + "; SELECT SCOPE_IDENTITY()";
                    sqlCommand.Parameters.AddWithValue("indexNumber", model.IndexNumber);
                    sqlCommand.Parameters.AddWithValue("firstName", model.FirstName);
                    sqlCommand.Parameters.AddWithValue("lastName", model.LastName);
                    sqlCommand.Parameters.AddWithValue("birthDate", model.BirthDate);
                    sqlCommand.Parameters.AddWithValue("idEnrollment", idEnrollment);

                    int rows = sqlCommand.ExecuteNonQuery();
                    if(rows <= 0)
                    {
                        transaction.Rollback();
                        result.Message = "Could not create Student";
                        result.Success = false;
                        return result;
                    }

                    result.Model = new EnrollStudentResp
                    {
                        FirstName = model.FirstName,
                        LastName = model.LastName,
                        IndexNumber = model.IndexNumber,
                        Semester = 1,
                        StartDate = Start
                    };

                    transaction.Commit();

                }
                catch (SqlException e)
                {
                    Console.WriteLine(e.Message);
                    result.Success = false;
                    result.Message = "Error";
                    transaction.Rollback();
                }
            }

            return result;
        }

        public Study GetStudy(string nameOfStudy)
        {
            throw new NotImplementedException();
        }

        public PromoteResults PromoteStudent(PromoteStudentReq model)
        {
            PromoteResults result = new PromoteResults
            {
                Success = true,
                Message = string.Empty
            };

            using (var connect = new SqlConnection(Connection))
            using (var sqlCommand = new SqlCommand())
            {
                sqlCommand.Connection = connect;
                connect.Open();

                try
                {
                    sqlCommand.CommandText = "Select * from enrollment where IdStudy = (select IdStudy from studies where Name = @studyName) and Semester = @semester";
                    sqlCommand.Parameters.AddWithValue("studyName", model.Studies);
                    sqlCommand.Parameters.AddWithValue("semester", model.Semester);

                    var reader = sqlCommand.ExecuteReader();
                    if (!reader.Read())
                    {
                        reader.Close();
                        result.Message = "No such enrollment";
                        result.Success = false;
                        return result;
                    }

                    reader.Close();
                    sqlCommand.Parameters.Clear();
                    sqlCommand.CommandText = "PromoteStudents1";
                    sqlCommand.CommandType = CommandType.StoredProcedure;
                    sqlCommand.Parameters.AddWithValue("@studiesName", model.Studies);
                    sqlCommand.Parameters.AddWithValue("@oldSemester", model.Semester);

                    sqlCommand.ExecuteNonQuery();
                    result.Model = new PromoteEnrollResp
                    {
                        Semester = model.Semester + 1,
                        Studies = model.Studies
                    };
                }
                catch (SqlException e)
                {
                    Console.WriteLine(e.Message);
                    result.Success = false;
                    result.Message = "Error";
                }
            }

            return result;

        }

        EnrollStudent IStudentsDbService.EnrollStudent(EnrollStudentReq enrollStudentRequest)
        {
            throw new NotImplementedException();
        }

        bool IStudentsDbService.PromoteStudent(PromoteStudentReq promoteStudentRequest)
        {
            throw new NotImplementedException();
        }
    }
}