using System.ComponentModel.DataAnnotations.Schema;

namespace CarManagement.Models
{
    [Table("car_details")]
    public class Car
    {
        [Column("car_id")]
        public int Id { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string CarName { get; set; }

        [Column(TypeName = "varchar(255)")]
        public string CarModel { get; set; }

        // [Column("brand_name")]
        [Column(TypeName = "varchar(255)")]
        public string Brand { get; set; }

        //[Column("price_value")]
        public double Price { get; set; }

        //[Column("is_available")]
        public bool Available { get; set; }

        //[Column("car_status")]
        [Column(TypeName = "varchar(255)")]
        public string Status { get; set; } // e.g., Available, Booked


    }
}
