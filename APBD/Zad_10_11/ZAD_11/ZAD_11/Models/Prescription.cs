﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace ZAD_11.Models
{
    public class Prescription
    {
        public int IdPrescription { get; set; }

        public DateTime Date { get; set; }

        public DateTime DueDate { get; set; }

        [ForeignKey("Patient")]
        public int? IdPatient { get; set; }

        public Patient Patient { get; set; }

        [ForeignKey("Doctor")]
        public int? IdDoctor { get; set; }

        public Doctor Doctor { get; set; }
    }
}
