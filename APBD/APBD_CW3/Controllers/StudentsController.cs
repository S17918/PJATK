using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using APBD_CW3.Services;
using APBD_CW3.Models;
using Microsoft.AspNetCore.Mvc;

namespace APBD_CW3.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly Service _dbService;

        public StudentsController(Service dbService)
        {
            _dbService = dbService;
        }

        [HttpGet]
        public IActionResult GetStudent()
        {
            List<Student> student_list = new List<Student>();

            using (var con = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True")){
                using (SqlCommand com = new SqlCommand()){

                    com.Connection = con;

                    com.CommandText = @"SELECT [FirstName],[LastName],[BirthDate],[Name],[Semester] FROM Student INNER JOIN Enrollment 
                    ON Student.IdEnrollment = Enrollment.IdEnrollment Inner Join Studies ON Enrollment.IdStudy = Studies.IdStudy;";
                    
                    con.Open();
                    var data_reader = com.ExecuteReader();

                    while(data_reader.Read()){
                        Student stud = new Student();
                        stud.FirstName = data_reader["FirstName"].ToString();
                        stud.LastName = data_reader["LastName"].ToString();
                        stud.BirthDate = DateTime.Parse(data_reader["BirthDate"].ToString());
                        stud.StudiesName = data_reader["Name"].ToString();
                        stud.SemesterNumber = int.Parse(data_reader["Semester"].ToString());

                        student_list.Add(stud);
                    }   
                }
            }
            return Ok(student_list);
        }


        
        [HttpGet("{indexNumber}")]
        public IActionResult GetStudent(string IndexNumber)
        {
            Student stud = new Student();

            using (var con = new SqlConnection("Data Source=db-mssql;Initial Catalog=s17918;Integrated Security=True")){
                using (SqlCommand com = new SqlCommand()){
                    com.Connection = con;
                    com.CommandText = @"SELECT [FirstName],[LastName],[BirthDate],[Name],[Semester] FROM Student INNER JOIN Enrollment 
                    ON Student.IdEnrollment = Enrollment.IdEnrollment Inner Join Studies ON Enrollment.IdStudy = Studies.IdStudy;"; 

                    com.Parameters.AddWithValue("indexNumber", IndexNumber);
                    con.Open();
                    var data_reader = com.ExecuteReader();

                    while(data_reader.Read()){
                        stud.FirstName = data_reader["FirstName"].ToString();
                        stud.LastName = data_reader["LastName"].ToString();
                        stud.BirthDate = DateTime.Parse(data_reader["BirthDate"].ToString());
                        stud.StudiesName = data_reader["Name"].ToString();
                        stud.SemesterNumber = int.Parse(data_reader["Semester"].ToString());
                    }
                }
            }
            return Ok(stud);
        }

        [HttpPost]
        public IActionResult CreateStudent(Student student)
        {
            student.IndexNumber = $"s{new Random().Next(1, 20000)}";
            return Ok(student);
        }
        [HttpPut]
        public IActionResult PutStudent(int stud_id)
        {
            if (stud_id != 0)
            {
                return Ok("Aktualizacja zakończona");
            }

            return NotFound("Nie udało się zaktualizować studenta");

        }

        [HttpDelete]
        public IActionResult DeleteStudent(int stud_id)
        {
            if (stud_id != 0)
            {
                return Ok("Usuwanie zakończone");
            }

            return NotFound("Nie udało się usunąć studenta");

        }
    }
}