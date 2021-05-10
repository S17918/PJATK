using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace Kolokwium.Models
{
    public class ArtistEvent
    {
        public int IdEvent { get; set; }
        public Event Event { get; set; }

        public int IdArtist { get; set; }
        public Artist Artist { get; set; }

        public DateTime PerformanceDate { get; set; }
    }
}
