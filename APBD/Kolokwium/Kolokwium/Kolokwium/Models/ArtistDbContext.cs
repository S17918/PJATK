using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Kolokwium.Models
{
    public class ArtistDbContext : DbContext
    {
        public DbSet<Artist> Artists { get; set; }

        public DbSet<Event> Events { get; set; }

        public DbSet<ArtistEvent> ArtistEvents { get; set; }

        public DbSet<EventOrganiser> EventOrganisers { get; set; }

        public DbSet<Organiser> Organisers { get; set; }

        public ArtistDbContext()
        {

        }

        public ArtistDbContext(DbContextOptions options)
        :base(options){

        }

        protected override void OnModelCreating(ModelBuilder model)
        {
            base.OnModelCreating(model);

            model.Entity<Artist>().HasKey(key => new { key.IdArtist });
            model.Entity<Event>().HasKey(key => new { key.IdEvent });
            model.Entity<Organiser>().HasKey(key => new { key.IdOrganiser });

            model.Entity<ArtistEvent>().HasKey(key => new { key.IdArtist, key.IdEvent });
            model.Entity<EventOrganiser>().HasKey(key => new { key.IdEvent, key.IdOrganiser });

            model.Entity<ArtistEvent>()
                .HasOne<Artist>(e => e.Artist)
                .WithMany(r => r.ArtistEvents)
                .HasForeignKey(r => r.IdArtist);

            model.Entity<ArtistEvent>()
                .HasOne<Event>(e => e.Event)
                .WithMany(v => v.ArtistEvents)
                .HasForeignKey(v => v.IdEvent);

            model.Entity<EventOrganiser>()
                .HasOne<Event>(o => o.Event)
                .WithMany(v => v.EventOrganisers)
                .HasForeignKey(v => v.IdEvent);

            model.Entity<EventOrganiser>()
                .HasOne<Organiser>(e => e.Organiser)
                .WithMany(r => r.EventOrganisers)
                .HasForeignKey(r => r.IdOrganiser);

            model.Entity<Artist>()
                .Property(s => s.Nickname)
                .HasMaxLength(50);

        }
    }
}
