using System;

namespace APBD_CW3.Models
{

public class Student
    {
        public int IdStudent { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime BirthDate { get; set; }
        public string StudiesName { get; set; }
        public int SemesterNumber { get; set; }
        public string IndexNumber { get; set; }
    }
}