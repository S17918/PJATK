using APBD_CW3.Services.Responses;


namespace APBD_CW3.Services
{
    public class StudentResults
    {
        public bool Success { get; set; }
        public string Message { get; set; }
        public EnrollStudentResp Model { get; set; }
    }
}