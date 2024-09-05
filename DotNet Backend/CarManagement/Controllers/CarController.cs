using CarManagement.Interface;
using CarManagement.Models;
using CarManagement.Repository;
using Microsoft.AspNetCore.Mvc;

namespace CarManagement.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CarController : ControllerBase
    {
        //private readonly CarRepository _carRepository;

        public readonly ICar _carRepository;



        public CarController(ICar carRepository)
        {
            _carRepository = carRepository;
        }

        // GET: api/Car
        [HttpGet]
        public IActionResult GetAllCars()
        {
            try
            {
                var cars = _carRepository.GetAllCarDetails();
                return Ok(cars);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // GET: api/Car/5
        [HttpGet("{id}")]
        public IActionResult GetCarById(int id)
        {
            try
            {
                var car = _carRepository.GetCarById(id);
                if (car == null)
                {
                    return NotFound($"Car with ID {id} not found.");
                }

                return Ok(car);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // POST: api/Car
        [HttpPost]
        public IActionResult AddCar([FromBody] Car car)
        {
            try
            {
                if (car == null)
                {
                    return BadRequest("Car object is null.");
                }

                if (!ModelState.IsValid)
                {
                    return BadRequest("Invalid car object.");
                }

                _carRepository.AddCar(car);
                return CreatedAtAction(nameof(GetCarById), new { id = car.Id }, car);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // PUT: api/Car/5
        [HttpPut("{id}")]
        public IActionResult UpdateCar(int id, [FromBody] Car car)
        {
            try
            {
                if (car == null || car.Id != id)
                {
                    return BadRequest("Car object is null or ID mismatch.");
                }

                if (!ModelState.IsValid)
                {
                    return BadRequest("Invalid car object.");
                }

                var existingCar = _carRepository.GetCarById(id);
                if (existingCar == null)
                {
                    return NotFound($"Car with ID {id} not found.");
                }

                _carRepository.UpdateCar(car);
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // DELETE: api/Car/5
        [HttpDelete("{id}")]
        public IActionResult DeleteCar(int id)
        {
            try
            {
                var car = _carRepository.GetCarById(id);
                if (car == null)
                {
                    return NotFound($"Car with ID {id} not found.");
                }

                _carRepository.DeleteCar(id);
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }
    }
}
