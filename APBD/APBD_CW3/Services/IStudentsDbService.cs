using APBD_CW3.Services.Requests;
using APBD_CW3.Models;

namespace APBD_CW3.Services
{
    public interface IStudentsDbService
    {
        public bool PromoteStudent(PromoteStudentReq promoteStudentRequest);

        public Study GetStudy(string nameOfStudy);

        public EnrollStudent EnrollStudent(EnrollStudentReq enrollStudentRequest);
    }
}