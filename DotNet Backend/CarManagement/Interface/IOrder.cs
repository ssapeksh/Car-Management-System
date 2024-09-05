using CarManagement.Models;

namespace CarManagement.Interface
{
    public interface IOrder
    {

        public List<Order> GetDetailsOfOrders();

        public Order GetOrderDetail(int id);

        public void AddOrder(Order order);

        public void RemoveOrder(int id);

        public void UpdateOrder(Order order);


    }
}
