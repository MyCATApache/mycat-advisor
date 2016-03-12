template.helper('dateFormat', function (date, format) {
    format = format || 'YYYY-MM-DD hh:mm:ss';
    return moment(parseInt(date)).format(format);
});
