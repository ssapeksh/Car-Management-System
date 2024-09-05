using CarManagement.Models;

namespace CarManagement.Interface
{
    public interface ICar
    {
        public  List<Car> GetAllCarDetails();

        public Car GetCarById(int id);
        
        public  void AddCar(Car car);

        public void UpdateCar(Car car);

        public void DeleteCar(int id);


    }
}
