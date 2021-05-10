using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Configurations
{
    public class PrescriptionMedicamentEfConfiguration : IEntityTypeConfiguration<PrescriptionMedicament>
    {
        public void Configure(EntityTypeBuilder<PrescriptionMedicament> builder)
        {
            builder.HasKey(pm => new { pm.IdMedicament, pm.IdPrescription });

            builder
                .Property(pm => pm.Details)
                .HasMaxLength(100)
                .IsRequired();
        }
    }
}
