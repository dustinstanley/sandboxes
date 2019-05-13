using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CoreWebApp.Services;
using Microsoft.AspNetCore.Mvc;

namespace CoreWebApp.Controllers
{
    [Route("api/[controller]")]
    public class SampleDataController : Controller
    {
        private readonly ISampleDataService _sampleDataService;

        public SampleDataController(ISampleDataService sampleDataService)
        {
            _sampleDataService = sampleDataService;
        }
        
        [HttpGet("[action]")]
        public IEnumerable<WeatherForecast> WeatherForecasts(int startDateIndex)
        {
            return _sampleDataService.GetWeatherForecasts(startDateIndex);
        }
    }
}