using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Kolokwium.Models
{
    public class Organiser
    {
        public int IdOrganiser { get; set; }
        public String Name { get; set; }

        public IList<EventOrganiser> EventOrganisers { get; set; }
    }
}
