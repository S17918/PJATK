using APBD_CW3.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace APBD_CW3.Services
{
    public class DbService : Service
    {
        public Student GetStudent(string indexNumber)
        {
            Student student = new Student();
            try
            {
                using (var connect = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True"))
                using (var command = new SqlCommand())
                {
                    command.Connection = connect;
                    command.CommandText = "SELECT * FROM STUDENT WHERE IndexNumber = @indexNumber";
                    command.Parameters.AddWithValue("indexNumber", indexNumber);

                    connect.Open();
                    var reader = command.ExecuteReader();

                    if (!reader.Read())
                    {
                        return null;
                    }

                    student.IndexNumber = reader["IndexNumber"].ToString();
                    student.FirstName = reader["FirstName"].ToString();
                    student.LastName = reader["LastName"].ToString();
                    student.BirthDate = (DateTime)reader["BirthDate"];

                    connect.Close();
                }
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
                return null;
            }
            return student;
        }
            

        public IEnumerable<Enrollment> GetStudentEnrollment(string studentId)
        {
            List<Enrollment> enrollments = new List<Enrollment>();
            using (var connect = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True"))
            using (var command = new SqlCommand())
            {
                command.Connection = connect;
                command.CommandText = $"SELECT * FROM dbo.ENROLLMENT WHERE IdEnrollment = (SELECT IDENROLLMENT FROM dbo.STUDENT WHERE INDEXNUMBER = @studentId)";
                command.Parameters.AddWithValue("studentId", studentId);

                connect.Open();
                var reader = command.ExecuteReader();

                while (reader.Read())
                {

                    Console.WriteLine(reader);

                    Enrollment enrollment = new Enrollment();

                    enrollment.Semester = (int)reader["Semester"];
                    enrollment.IdEnrollment = (int)reader["IdEnrollment"];
                    enrollment.IdStudy = (int)reader["IdStudy"];
                    enrollment.StartDate = System.Convert.ToDateTime(reader["StartDate"].ToString());

                    enrollments.Add(enrollment);
                }
                connect.Close();
            }
            return enrollments;
        }

        public IEnumerable<Student> GetStudents()
        {
            List<Student> students = new List<Student>();

            using (var connect = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True"))
            using (var command = new SqlCommand())
            {
                command.Connection = connect;
                command.CommandText = "SELECT * FROM STUDENT";

                connect.Open();

                var reader = command.ExecuteReader();
                while (reader.Read())
                {
                    Student student = new Student();

                    student.FirstName = reader["FirstName"].ToString();
                    student.LastName = reader["LastName"].ToString();
                    student.IndexNumber = reader["IndexNumber"].ToString();

                    students.Add(student);
                }
                connect.Close();
            }
            return students;
        }

        public Study GetStudy(string studyName)
        {
            using (var connect = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True"))
            using (var command = new SqlCommand())
            {
                command.Connection = connect;
                command.CommandText = "SELECT * FROM STUDIES WHERE NAME = @studyName";
                command.Parameters.AddWithValue("studyName", studyName);

                connect.Open();
                var reader = command.ExecuteReader();

                Study study = new Study();

                if (!reader.Read())
                {
                    return null;
                }

                study.IdStudy = (int)reader["IdStudy"];
                study.Name = reader["Name"].ToString();

                connect.Close();
                return study;

            }
        }
    }
}
