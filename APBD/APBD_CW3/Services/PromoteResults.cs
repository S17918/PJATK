using APBD_CW3.Services.Responses;

namespace APBD_CW3.Services
{
    public class PromoteResults
    {
        public bool Success { get; set; }
        public string Message { get; set; }
        public PromoteEnrollResp Model { get; set; }
    }
}