using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Kolokwium.Models
{
    public class Event
    {
        [Key]
        public int IdEvent { get; set; }
        public String Name { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public IList<ArtistEvent> ArtistEvents { get; set; }
        public IList<EventOrganiser> EventOrganisers { get; set; }

    }
}
