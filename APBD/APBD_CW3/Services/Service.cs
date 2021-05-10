using APBD_CW3.Controllers;
using APBD_CW3.Models;
using System.Collections.Generic;

namespace APBD_CW3.Services
{
    public interface Service
    {
        public IEnumerable<Student> GetStudents();
        public IEnumerable<Enrollment> GetStudentEnrollment(string studentId);
        public Study GetStudy(string studyName);
        public Student GetStudent(string indexNumber);
    }
}