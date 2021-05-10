using System;

namespace APBD_CW3.Services.Responses
{
    public class EnrollStudentResp
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string IndexNumber { get; set; }
        public int Semester { get; set; }
        public DateTime StartDate { get; set; }
    }
}