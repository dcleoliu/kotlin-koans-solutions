import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
    this.addTimeIntervals(timeInterval, 1)

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)
operator fun TimeInterval.times(times: Int) =
    RepeatedTimeInterval(this, times)
operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) =
    this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.times)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
