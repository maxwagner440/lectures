<world-time-picker>
<ul>
    <li each="{ cities }">
        <a onclick="{ newTimezone }" data-zone="{ zone }" href="#">{ title }</a>
    </li>
</ul>


<script>
    this.cities = [
        { 
            title: 'New York',
            zone: 'America/New_York',
        },
        {
            title: 'Los Angeles',
            zone: 'America/Los_Angeles',
        },
        {
            title: 'Tokyo',
            zone: 'Asia/Tokyo',
        },
    ];

    this.newTimezone = function(event) {
        event.preventDefault();
        var zone = event.target.getAttribute('data-zone');
        opts.bus.trigger('new_timezone', zone);
    }
</script>
</world-time-picker>