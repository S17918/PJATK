using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace ZAD_11.Models
{
    public class PrescriptionMedicament
    {
        [ForeignKey("Medicament")]
        public int IdMedicament { get; set; }

        public Medicament Medicament { get; set; }

        [ForeignKey("Prescription")]
        public int IdPrescription { get; set; }

        public Prescription Prescription { get; set; }

        public int? Dose { get; set; }

        public string Details { get; set; }
    }
}
