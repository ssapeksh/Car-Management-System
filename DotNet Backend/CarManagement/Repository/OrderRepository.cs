using CarManagement.Data;
using CarManagement.Interface;
using CarManagement.Models;
using Microsoft.EntityFrameworkCore;

namespace CarManagement.Repository
{
    public class OrderRepository : IOrder
    {
        public readonly ApplicationDbContext _applicationdbcontext;

        public OrderRepository(ApplicationDbContext applicationdbcontext)
        {
            _applicationdbcontext = applicationdbcontext;
        }
        public List<Order> GetDetailsOfOrders()
        {
            try
            {
                return _applicationdbcontext.Orders.ToList();
            }
            catch
            {
                throw;
            }
        }   

        public Order GetOrderDetail(int id)
        {
            try
            {
                Order? order = _applicationdbcontext.Orders.Find(id);
                if(order != null)
                { 
                    return order;
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

        public void AddOrder(Order order)
        {
            try
            {
                _applicationdbcontext.Add(order);
                _applicationdbcontext.SaveChanges();
            }
            catch
            {
                throw;
            }
        }

        public void RemoveOrder(int id)
        {
            try
            {
                Order? order = _applicationdbcontext.Orders.Find(id);
                if (order != null)
                {
                    _applicationdbcontext.Remove(order);
                    _applicationdbcontext.SaveChanges();
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

        public void UpdateOrder(Order order)
        {
            try
            {
                _applicationdbcontext.Entry(order).State = EntityState.Modified;
                _applicationdbcontext.SaveChanges();
            }
            catch
            {
                throw;
            }
        }
    }
}
