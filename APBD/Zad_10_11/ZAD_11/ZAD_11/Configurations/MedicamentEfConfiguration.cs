using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Configurations
{
    public class MedicamentEfConfiguration : IEntityTypeConfiguration<Medicament>
    {
        public void Configure(EntityTypeBuilder<Medicament> builder)
        {
            builder.HasKey(m => m.IdMedicament);

            builder
                .Property(m => m.Name)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(m => m.Description)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(m => m.Type)
                .HasMaxLength(100)
                .IsRequired();
        }
    }
}
