#include <stdio.h>
#include <stdlib.h>
#include <mysql.h>

MYSQL *con;
MYSQL_RES *res;
MYSQL_ROW row;

char *server = "localhost";
char *user = "root";
char *pass = "q1w2e3r4";
char *db = "conectandoc";

int main()
{
    //CONECTANDO AO BANCO
    con = mysql_init(NULL);
    if(!mysql_real_connect(con, server, user, pass, db, 0, NULL, 0)){
        fprintf(stderr, "%s\n", mysql_error());
    }
    //COMANDO
    if(mysql_query(con, "show DB")){
        fprintf(stderr, "%s\n", mysql_error(con));
        exit(1);
    }
}
