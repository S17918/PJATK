
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using ZAD_10.Models;

namespace ZAD_10.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        [HttpGet]
        public IActionResult GetStudents()
        {
            var db = new s17918();

            return Ok(db.Student.ToList());
        }

        [HttpPut("{indexNumber}")]
        public IActionResult UpdateStudent(string indexNumber, Student studentDto)
        {
            var db = new s17918();

            var student = db.Student
                .Where(s => s.IndexNumber == indexNumber)
                .Single();

            student.FirstName = studentDto.FirstName;
            student.LastName = studentDto.LastName;
            db.SaveChanges();

            return Ok(student);
        }

        [HttpDelete("{indexNumber}")]
        public IActionResult RemoveStudent(string indexNumber)
        {
            var db = new s17918();

            var student = db.Student
                .Where(s => s.IndexNumber == indexNumber)
                .Single();

            db.Remove(student);
            db.SaveChanges();

            return Ok();
        }
    }
}
