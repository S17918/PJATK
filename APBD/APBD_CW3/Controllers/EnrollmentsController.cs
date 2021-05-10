using System;
using System.Collections.Generic;
using System.Linq;
using APBD_CW3.Services;
using APBD_CW3.Services.Requests;
using APBD_CW3.Services.Responses;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;

namespace APBD_CW3.Controllers
{
    [Route("api/[controller]")]
    [ApiController]

    public class EnrollmentsController : ControllerBase
    {
        private IStudentsDbService priv_service;

        public EnrollmentsController(IStudentsDbService service)
        {
            priv_service = service;
        }

        [HttpPost("promotions")]
        public IActionResult PromoteStudent(PromoteStudentReq request)
        {
            if (this.priv_service.PromoteStudent(request))
            {
                return Ok();
            };

            return BadRequest();
        }

        [HttpPost]
        public IActionResult EnrollStudent(EnrollStudentReq request)
        {
            EnrollStudent enrollStud = this.priv_service.EnrollStudent(request);

            EnrollStudentResp enrollStudResp = new EnrollStudentResp(){
                Semester = enrollStud.Semester, 
                LastName = enrollStud.LastName, 
                StartDate = enrollStud.StartDate
            };

            return Ok(enrollStudResp);

        }



    }
}