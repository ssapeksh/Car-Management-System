using CarManagement.Data;
using CarManagement.Interface;
using CarManagement.Models;
using Microsoft.EntityFrameworkCore;

namespace CarManagement.Repository
{
    public class CarRepository : ICar
    {
        public readonly ApplicationDbContext _dbcontext;

        public CarRepository(ApplicationDbContext dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public List<Car> GetAllCarDetails()
        {
            try
            {
                return _dbcontext.Cars.ToList();

            }
            catch
            {
                throw;
            }
        }


        public Car GetCarById(int id)
        {
            try
            {
                Car? car = _dbcontext.Cars.Find(id);
                if(car != null)
                {
                    return car;
                }
                else
                {
                    throw new ArgumentNullException();
                }
            }
            catch
            {
                throw;
            }
        }

        public void AddCar(Car car)
        {
            try
            {
                _dbcontext.Cars.Add(car);
                _dbcontext.SaveChanges();
            }
            catch
            {
                throw ;
            }
        }

        public void UpdateCar(Car car)
        {
            var existingUser = _dbcontext.Cars.Local.FirstOrDefault(u => u.Id == car.Id);
            if (existingUser != null)
            {
                _dbcontext.Entry(existingUser).State = EntityState.Detached;
            }

            // Attach the updated entity and mark it as modified
            _dbcontext.Entry(car).State = EntityState.Modified;
            _dbcontext.SaveChanges();
        }

        public void DeleteCar(int id)
        {
            try
            {
                Car? car = _dbcontext.Cars.Find(id);
                if (car != null)
                {
                    _dbcontext.Cars.Remove(car);
                    _dbcontext.SaveChanges();
                }
                else
                {
                    throw new ArgumentNullException();
                }
            }
            catch
            {
                throw;
            }
        }
    }
}
