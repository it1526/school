function getAll() {  
    console.log(new Date());
    $.ajax({
        url: 'http://localhost:3000/students',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function (data, textStatus, xhr) {
            console.log(textStatus);
            $('#list').html('');
            $('#list').append(list(data));
            view(data[0]);
            $('#list a').on('click', function(){
                getById($(this).attr('id'));
            });
            $('#list .delete').on('click', function(){
                remove($(this).attr('id'));
            });
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log('Error in Operation');
        }
    });    
}

function studentTable(){
    $.get("http://localhost:3000/students/",function(data,status){
    $("#studenti").html("<tr><th>Jméno</th><th>Příjmení</th><th>Absence</th><th>Pohlaví</th><th>Průměr</th></tr>");    
    for(var i = 0;i < data.length;i++){
            $("#studenti").append("<tr onclick='viewStudent("+data[i].id+")'><td>"+data[i].jmeno+"</td><td>"+data[i].prijmeni+"</td><td>"+(data[i].absence == null ? "---" : data[i].absence)+"</td><td>"+data[i].pohlavi+"</td><td>"+(data[i].prospech == null ? "---" : data[i].prospech)+"</td></tr>");
        }
    },"json");
}

function viewStudent(id){
    $.get("http://localhost:3000/students/"+id,function(data,status){
        view(data[0]);    
    },"json");
}

function list(data) {
    var output = '<ul>';
    data.forEach(function(row,key){
        output += '<li><a href="#" id="'+row.id+'">'+row.prijmeni+', '+row.jmeno+'</a> [<a href="#" id="'+row.id+'" class="delete">X</a>]</li>';
    });
    output += '</ul>';
    return output;
}

function getById(id) {
    $.ajax({
        url: 'http://localhost:3000/students/'+id,
        type: 'GET',
        dataType: 'json',
        success: function (data, textStatus, xhr) {
            console.log(data);                
            var student = data[0];
            view(student);
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log('Error in Operation');
        }
    });                
}

function view(student) {
    $('#view').html('');
    $('#view').append('<h4>'+student.jmeno+' '+student.prijmeni+'</h4>');
    $('#view').append('<p>Narozen/a: <b>'+student.narozeni+'</b></p>');
    $('#view').append('<p>Absence: <b>'+ (student.absence == null ? '---' : student.absence) +'</b></p>');
    $('#view').append('<p>Průměrný prospěch: <b>'+ (student.prospech == null ? '---' : student.prospech) +'</b></p>');
    $('#view').append('<p>Obor: <b>'+ (student.obor == null ? '---' : student.obor) +'</b></p>');
    $('#view').append('<p>Poznámka: <b>'+ (student.poznamka == null ? '---' : student.poznamka) +'</b></p>');
    $('#view').append("<p><button onclick='remove("+student.id+");' type='button' class='btn btn-danger'>Smazat záznam</button>");
    studentTable();
}

function remove(id) {
    $.ajax({
        url: 'http://localhost:3000/students/'+id,
        type: 'DELETE',
        dataType: 'json',
        success: function (data, textStatus, xhr) {
            console.log(data);                
            getAll();
        },
        error: function (xhr, textStatus, errorThrown) {
            console.log('Error in Operation');
        }
    });                        
}
studentTable();
//getAll();