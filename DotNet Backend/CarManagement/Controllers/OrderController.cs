using CarManagement.Interface;
using CarManagement.Models;
using CarManagement.Repository;
using Microsoft.AspNetCore.Mvc;

namespace CarManagement.Controllers
{
    [Route("/api/orderadmin")]
    public class OrderController : ControllerBase
    {
        public readonly IOrder _orderRepository;

        public OrderController(IOrder orderRepository)
        {
            _orderRepository = orderRepository;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Order>>> GetAllOrdersDetails()
        {
            return await Task.FromResult(_orderRepository.GetDetailsOfOrders());
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Order>> GetOrderDetail(int id)
        {
            var order = await Task.FromResult(_orderRepository.GetOrderDetail(id));
            if (order == null)
            {
                return NotFound();
            }

            return order;
        }

        [HttpPost]
        public async Task<ActionResult<Order>> AddOrder([FromBody]Order order)
        {
            _orderRepository.AddOrder(order);
            return await Task.FromResult(order);
        }


        [HttpDelete("{id}")]
        public IActionResult RemoveOrder(int id)
        {
            try
            {
                var order = _orderRepository.GetOrderDetail(id);
                if (order == null)
                {
                    return NotFound($"Order with ID {id} not found.");
                }

                _orderRepository.RemoveOrder(id);
                return NoContent(); // 204 No Content
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // PUT: api/Order/5
        [HttpPut("{id}")]
        public IActionResult UpdateOrder(int id, [FromBody] Order order)
        {
            try
            {
                if (order == null || order.OrderId != id)
                {
                    return BadRequest("Order object is null or ID mismatch.");
                }

                var existingOrder = _orderRepository.GetOrderDetail(id);
                if (existingOrder == null)
                {
                    return NotFound($"Order with ID {id} not found.");
                }

                _orderRepository.UpdateOrder(order);
                return NoContent(); // 204 No Content
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

    }
}
