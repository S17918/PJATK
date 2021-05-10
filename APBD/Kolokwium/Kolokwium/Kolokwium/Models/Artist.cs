using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Kolokwium.Models
{
    public class Artist
    {
        public int IdArtist { get; set; }
        public String Nickname { get; set; }
        public IList<ArtistEvent> ArtistEvents { get; set; }

    }
}
