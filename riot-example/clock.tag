<clock>
    <div class="time">{ time }</div>

    <style>
        .time {
            font-size: 76%;
            width: 250px; height: 100px;
            background: white;
            font-size: 4em;
            color: #707070;
            
            /* Centering everything */
            position: relative;
            left: 50%; top: 50%;
            margin-left: -125px; 
            
            text-align: center;
            line-height: 100px;
            
            border-top: 5px solid #E54B6B;
            background-image: linear-gradient(#f0f0f0, white);
        }
    </style>

    <script>
        var self = this;
        this.timezone;

        this.on('mount', function() {
            setInterval(this.setTime, 500);
            this.setTime();
        });

        opts.bus.on('new_timezone', function(zone) {
            self.timezone = zone;
        })

        this.setTime = function() {
            var date;
            if(self.timezone !== undefined) {
                date = moment().tz(self.timezone);
            } else {
                date = moment();
            }
            
            self.time = date.format("hh:mm:ss");
            self.update();
        }
    </script>
</clock>