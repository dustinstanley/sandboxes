using System.Collections.Generic;
using System.Linq;
using CoreWebApp.Controllers;
using CoreWebApp.Services;
using FluentAssertions;
using NSubstitute;
using Xunit;

namespace CoreWebAppTests.Controllers
{
    public class SampleDataControllerTest
    {
        private SampleDataController _target;
        private ISampleDataService _mockDataService;
        
        public SampleDataControllerTest()
        {
            _mockDataService = Substitute.For<ISampleDataService>();
            _target = new SampleDataController(_mockDataService);
        }
        
        [Fact]
        public void Test1()
        {
            _mockDataService.GetWeatherForecasts(Arg.Any<int>())
                .Returns(new List<WeatherForecast>()
                {
                    new WeatherForecast() { DateFormatted = "12345", Summary = "Summary1", TemperatureC = 50 },
                    new WeatherForecast() { DateFormatted = "12345", Summary = "Summary1", TemperatureC = 50 },
                    new WeatherForecast() { DateFormatted = "12345", Summary = "Summary1", TemperatureC = 50 }
                });
            IEnumerable<WeatherForecast> actual = _target.WeatherForecasts(0);
            var weatherForecasts = actual.ToList();
            weatherForecasts.Should().NotContainNulls();
            weatherForecasts.Should().HaveCount(3);
        }
    }
}