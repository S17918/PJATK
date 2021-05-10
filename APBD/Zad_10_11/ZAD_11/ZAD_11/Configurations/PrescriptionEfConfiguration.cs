using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Configurations
{
    public class PrescriptionEfConfiguration : IEntityTypeConfiguration<Prescription>
    {
        public void Configure(EntityTypeBuilder<Prescription> builder)
        {
            builder.HasKey(p => p.IdPrescription);

            builder
                .Property(p => p.Date)
                .HasColumnType("Date")
                .IsRequired();

            builder
                .Property(p => p.DueDate)
                .HasColumnType("Date")
                .IsRequired();

            var prescriptions = new List<Prescription>();
            prescriptions.Add(new Prescription
            {
                IdPrescription = 1,
                Date = DateTime.Now,
                DueDate = DateTime.Now.AddDays(10),
                IdPatient = 1,
                IdDoctor = 1
            });
            prescriptions.Add(new Prescription
            {
                IdPrescription = 2,
                Date = DateTime.Now,
                DueDate = DateTime.Now.AddDays(10),
                IdPatient = 1,
                IdDoctor = 2
            });
            prescriptions.Add(new Prescription
            {
                IdPrescription = 3,
                Date = DateTime.Now,
                DueDate = DateTime.Now.AddDays(10),
                IdPatient = 2,
                IdDoctor = 2
            });

            builder.HasData(prescriptions);
        }
    }
}
