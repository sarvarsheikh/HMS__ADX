package com.hotel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
class RealTime {




            public String get_Real_Time_date() {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                return dtf.format(now);
            }
        }



