using System.ComponentModel.DataAnnotations;

namespace APBD_CW3.Services.Requests
{
    public class PromoteStudentReq
    {
        [Required]
        public string Studies { get; set; }

        [Required]
        public int Semester { get; set; }

    }
}