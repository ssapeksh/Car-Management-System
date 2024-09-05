using CarManagement.Interface;
using CarManagement.Models;
using Microsoft.AspNetCore.Mvc;

namespace CarManagement.Controllers
{
    [Route("/api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        public readonly IUser _userRepository;

        public UserController(IUser userRepository)
        {
            _userRepository = userRepository;
        }

        [HttpGet]
        public ActionResult<IEnumerable<User>> GetAllUsers()
        {
            try
            {
                return Ok(_userRepository.GetAllUsersDetails());
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // GET: api/User/5
        [HttpGet("{id}")]
        public ActionResult<User> GetUserById(int id)
        {
            try
            {
                var user = _userRepository.GetUserDetailById(id);
                if (user == null)
                {
                    return NotFound($"User with ID {id} not found.");
                }

                return Ok(user);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // POST: api/User
        [HttpPost]
        public ActionResult<User> CreateUser([FromBody] User user)
        {
            try
            {
                if (user == null)
                {
                    return BadRequest("User object is null.");
                }

                if (!ModelState.IsValid)
                {
                    return BadRequest("Invalid user object.");
                }

                _userRepository.AddUser(user);
                return CreatedAtAction("GetUserById", new { id = user.Id }, user);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // PUT: api/User/5
        [HttpPut("{id}")]
        public IActionResult UpdateUser(int id, [FromBody] User user)
        {
            try
            {
                if (user == null || user.Id != id)
                {
                    return BadRequest("User object is null or ID mismatch.");
                }

                if (!ModelState.IsValid)
                {
                    return BadRequest("Invalid user object.");
                }

                var existingUser = _userRepository.GetUserDetailById(id);
                if (existingUser == null)
                {
                    return NotFound($"User with ID {id} not found.");
                }

                // Update existing user details
                existingUser.Role = user.Role;
                existingUser.User_Name = user.User_Name;
                // Update other properties as needed

                _userRepository.UpdateUser(existingUser); // Use existingUser here
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

        // DELETE: api/User/5
        [HttpDelete("{id}")]
        public IActionResult DeleteUser(int id)
        {
            try
            {
                var user = _userRepository.GetUserDetailById(id);
                if (user == null)
                {
                    return NotFound($"User with ID {id} not found.");
                }

                _userRepository.DeleteUser(id);
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Internal server error: {ex.Message}");
            }
        }

    }
}
