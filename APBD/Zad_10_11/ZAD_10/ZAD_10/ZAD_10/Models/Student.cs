﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ZAD_10.Models
{
    public partial class Student
    {
        public string IndexNumber { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime BirthDate { get; set; }
        public int IdEnrollment { get; set; }
        public string Password { get; set; }
        public Guid? RefreshToken { get; set; }
        public string Salt { get; set; }

        public virtual Enrollment IdEnrollmentNavigation { get; set; }
    }
}
