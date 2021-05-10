using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Configurations
{
    public class PatientEfConfiguration : IEntityTypeConfiguration<Patient>
    {
        public void Configure(EntityTypeBuilder<Patient> builder)
        {
            builder.HasKey(p => p.IdPatient);

            builder
                .Property(p => p.FirstName)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(p => p.LastName)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(p => p.BirthDate)
                .HasColumnType("Date");

            var patients = new List<Patient>();
            patients.Add(new Patient { IdPatient = 1, FirstName = "Paweł", LastName = "Wręga", BirthDate = DateTime.Now });
            patients.Add(new Patient { IdPatient = 2, FirstName = "Karol", LastName = "Zygmunt", BirthDate = DateTime.Now });

            builder.HasData(patients);
        }
    }
}
