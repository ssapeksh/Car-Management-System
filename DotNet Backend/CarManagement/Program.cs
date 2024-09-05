using CarManagement.Data;
using CarManagement.Interface;
using CarManagement.Repository;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using System.Configuration;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

/*builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseMySql(Configuration.GetConnectionString("DefaultConnection"),
    ServerVersion.AutoDetect(Configuration.GetConnectionString("DefaultConnection"))));*/


var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? "FallbackConnectionString";
builder.Services.AddDbContext<ApplicationDbContext>(options =>
{
    options.UseMySQL(connectionString);
    
});

//builder.Services.AddTransient<IUser, UserRepository>();
builder.Services.AddScoped<IUser, UserRepository>();
builder.Services.AddScoped<ICar, CarRepository>();
builder.Services.AddScoped<IOrder, OrderRepository>();
builder.Services.AddControllers();

// Configure CORS
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAllOrigins",
        builder =>
        {
            builder.WithOrigins("http://localhost:3000")
                   .AllowAnyHeader()
                   .AllowAnyMethod();
        });
});






var app = builder.Build();

// Use CORS
app.UseCors("AllowAllOrigins");


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
