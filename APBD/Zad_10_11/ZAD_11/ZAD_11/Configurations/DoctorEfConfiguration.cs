using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Configurations
{
    public class DoctorEfConfiguration : IEntityTypeConfiguration<Doctor>
    {
        public DoctorEfConfiguration()
        {
        }

        public void Configure(EntityTypeBuilder<Doctor> builder)
        {
            builder
                .HasKey(d => d.Id);

            builder
                .Property(d => d.FirstName)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(d => d.LastName)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(d => d.Email)
                .HasMaxLength(100)
                .IsRequired();

            var doctors = new List<Doctor>();
            doctors.Add(new Doctor { Id = 1, FirstName = "Paweł", LastName = "Kowalski", Email = "p.kowalski@gmail.com" });
            doctors.Add(new Doctor { Id = 2, FirstName = "Robert", LastName = "Teodorczuk", Email = "rtodo@gmail.com" });
            doctors.Add(new Doctor { Id = 3, FirstName = "Karol", LastName = "Trach", Email = "karoltrach@gmail.com" });

            builder
                .HasData(doctors);
        }
    }
}
