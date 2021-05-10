using System;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;

namespace APBD_CW3.Middlewares
{
	public class LoggingMiddleware
	{
		private readonly RequestDelegate _next;
		private readonly string logsPath = "logi.txt";

		public LoggingMiddleware(RequestDelegate next)
		{
			_next = next;
		}

        public async Task InvokeAsync(HttpContext httpContext)
        {
            await _next(httpContext);

            using (var read = new StreamReader(httpContext.Request.Body))
            {
                string httpMethod = httpContext.Request.Method;
                string httpUrl = httpContext.Request.Path;
                string httpBody = await read.ReadToEndAsync();
                string httpQuery = httpContext.Request.QueryString.Value;

                string log = $"{httpMethod},{httpUrl},{httpBody},{httpQuery}{Environment.NewLine}";
                await File.AppendAllTextAsync(this.logsPath, log);
            }
        }
    }
}


