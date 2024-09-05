using System.ComponentModel.DataAnnotations.Schema;

namespace CarManagement.Models
{
    [Table("user_details")]
    public class User
    {
        [Column("User_Id")]
        public int Id { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string User_Name { get; set; }

        
        public int User_Age { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string Email { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string Password { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string Status { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string City { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string Role { get; set; }

        


    }
}
