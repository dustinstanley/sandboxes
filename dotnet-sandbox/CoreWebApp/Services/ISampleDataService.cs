using System.Collections.Generic;

namespace CoreWebApp.Services
{
    public interface ISampleDataService
    {
        IEnumerable<WeatherForecast> GetWeatherForecasts(int startDateIndex);
    }
    
    public class WeatherForecast
    {
        public string DateFormatted { get; set; }
        public int TemperatureC { get; set; }
        public string Summary { get; set; }

        public int TemperatureF
        {
            get { return 32 + (int) (TemperatureC / 0.5556); }
        }
    }
}