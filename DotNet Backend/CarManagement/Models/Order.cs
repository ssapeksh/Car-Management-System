using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace CarManagement.Models
{
    [Table("order_details")]
    public class Order
    {
        [Key]
        [Column("OrderId")]
        public int OrderId { get; set; }

        [Column("OrderDate")]
        public DateTime OrderDate { get; set; }

        [Column("Duration")]
        public int DurationDays { get; set; }

        [ForeignKey("UserId")]
        [Column("userId")]
        public int UserId { get; set; }
        public  User User { get; set; }

        [ForeignKey("CarId")]
        [Column("carId")]
        public int CarId { get; set; }
        public Car Car { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string OrderStatus { get; set; } // cancelled, in process, completed
    }
}
