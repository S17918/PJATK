using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Kolokwium.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium.Controllers
{
    [Route("api/artists")]
    [ApiController]
    public class ArtistController : ControllerBase
    {
        private readonly ArtistDbContext _context;

        public ArtistController(ArtistDbContext context)
        {
            _context = context;
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> Get(int id)
        {
            try
            {
                var artists = await _context.Artists
                    .Where(artists => artists.IdArtist
                    .Equals(id)).Select(artists => new
                {
                    artists.IdArtist,
                    artists.Nickname,
                    artist_events = artists.ArtistEvents
                    .OrderByDescending(ArtistEvent => ArtistEvent.Event.StartDate)
                    .Select(ArtistEvent => new
                    {
                        ArtistEvent.Event.IdEvent,
                        ArtistEvent.Event.Name,
                        ArtistEvent.Event.StartDate,
                        ArtistEvent.Event.EndDate,
                    })
                }).FirstAsync();
                return Ok(artists);
            }
            catch (InvalidOperationException e)
            {
                return NotFound("No such artist" + e);
            }
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var artists = await _context.Artists
                .Select(artists => new
            {
                artists.IdArtist,
                artists.Nickname,
                artist_events = artists.ArtistEvents
                .OrderByDescending(ArtistEvent => ArtistEvent.Event.StartDate)
                .Select(ArtistEvent => new
                {
                    ArtistEvent.Event.IdEvent,
                    ArtistEvent.Event.Name,
                    ArtistEvent.Event.StartDate,
                    ArtistEvent.Event.EndDate,
                })
            }).ToListAsync();
            return Ok(artists);
        }


        [HttpDelete("{id}")]
        public void Delete(int id)
        {

        }

        [HttpPut("{id}")]
        public void Put()
        {

        }

        [HttpPost]
        public void Post(String text)
        {

        }






    }
}