#include <stdio.h>
#include <stdlib.h>
#include<stdbool.h>
#include<windows.h>

#define I 4
#define M 6
#define N 15
//#define IN 30

//int T[IN];

typedef unsigned char AdrMac[M];
typedef unsigned char AdrIp[I];
typedef unsigned char Nom[N];
//Liste Chainee logiciels clients et logiciels serveurs
typedef struct LogicielsClients LogicielsClients;
struct LogicielsClients{
    char nom[30];
    LogicielsClients* suivant;
};

typedef struct LogicielsServeurs LogicielsServeurs;
struct LogicielsServeurs{
    char nom[30];
    LogicielsClients* suivant;
};

typedef struct ListeClients ListeClients;
struct ListeClients{
    LogicielsClients* premier;
};
typedef struct ListeServeurs ListeServeurs;
struct ListeServeurs{
    LogicielsServeurs* premier;
};

typedef struct Machine Machine;
struct Machine{
    //char nom[30];
	//char mac[24];
	Nom nom;
	AdrMac mac;
	bool connected;
	AdrIp ip;
	//char* logicielsClients[100];
	//char* logicielsServeurs[100];
	ListeClients* Clients;
	ListeServeurs* Serveurs;
};
typedef struct Parc Parc;
struct Parc{
    Machine machines[100];
    int nombre;
};
Parc p;

int MenuGeneral(){
   // Color(15,0);
	int choix,test;
	//do{
        system("cls");
        puts("\n");
        puts("------------------------- MENU -----------------------");
        puts(" 1) Gerer le parc");
        puts(" 2) Gerer le reseau");
        puts(" 3) Simuler des echanges entre clients et serveurs");
        puts(" 4) Effacer l'ecran");
        puts(" 5) Quitter");
        puts("------------------------------------------------------");
        printf("Quel est votre choix: ");
        test = scanf("%d",&choix);

        while(test==0 || choix<1 || choix > 5){
            int c;
            while ( ((c = getchar()) != '\n') && c != EOF);
            //MessageBeep(MB_ICONWARNING);
            printf("\a!!!Choix incorrect!!! Retapez: ");
            test = scanf("%d",&choix);
        }
       /* switch(choix){
            case 1 : GestionParc(); break;
            case 2 : GestionReseau(); break;
            case 3 : Simulations(); break;
            case 4 : system("cls"); break;
            case 5: puts("-----------");
                 printf("Bye Bye\n");
                 puts("-----------");
        }*/
}

int main(void)
{
    MenuGeneral();
    return 0;
}
