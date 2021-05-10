using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ZAD_11.Models;

namespace ZAD_11.Services
{
    public interface IDoctorDbService
    {
        public IEnumerable<Doctor> GetDoctors();

        public Doctor AddDoctor(Doctor doctor);

        public void UpdateDoctor(int doctorId, Doctor doctor);

        public void DeleteDoctor(int doctorId);
    }
}
