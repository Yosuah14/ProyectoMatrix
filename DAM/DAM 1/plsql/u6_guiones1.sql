declare
v_apellido emple.apellido%type;
v_dnombre depart.dnombre%type;
begin
select e.apellidos,d.dnombre
into v_apellido,v_dnombre from emple e,depart d where d.dept_no=e.dept_no;
end;