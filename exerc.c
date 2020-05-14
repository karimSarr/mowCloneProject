#include <stdio.h>
#include <stdlib.h>
#include<stdbool.h>
#include<windows.h>

#define I 4
#define M 6
#define N 15
#define IN 30

int T[IN];

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

void Interface(int T[]){
	int i;
	printf("\n");
	for(i=0;i<IN;i++)
		printf("-");
}

int IsOctet(int i){
	return i>=0 && i<256;
}

void NomSaisie(Nom nom){
	printf("nom NetBios: ");
	scanf("%s", nom);
}

void MacSaisie(AdrMac mac){
	int a,b,c,d,e,f,i;
	do{
		printf("Entrez l'adresse Mac:");
		i = scanf("%x-%x-%x-%x-%x-%x",&a,&b,&c,&d,&e,&f);
		if (i<6) {
			puts("Adresse non hexadecimal");
			while (getchar()!='\n');
			continue;
		}
		if ((!(IsOctet(a) && IsOctet(b) && IsOctet(c) && IsOctet(d)
		     && IsOctet(e) && IsOctet(f))))
			puts("Adresse Mac Incorrecte");
		else break;
	}while(1);
	mac[0] = (unsigned char)a;
	mac[1] = (unsigned char)b;
	mac[2] = (unsigned char)c;
	mac[3] = (unsigned char)d;
	mac[4] = (unsigned char)e;
	mac[5] = (unsigned char)f;
}

void Saisie(AdrIp ip){
	int a,b,c,d,i;
	do{
		i = scanf("%d.%d.%d.%d",&a,&b,&c,&d);
		if(i<4){
			puts("Adresse incorrecte");
			while (getchar()!='\n');
			continue;
		}
		if ((!(IsOctet(a) && IsOctet(b) && IsOctet(c) && IsOctet(d))))
			puts("Adresse incorrecte");
		else break;
	}while(1);
	ip[0] = (unsigned char)a;
	ip[1] = (unsigned char)b;
	ip[2] = (unsigned char)c;
	ip[3] = (unsigned char)d;
}

Machine SaisieMachine(){
	Machine m;
	NomSaisie(m.nom);
	MacSaisie(m.mac);
	m.connected = false;
	m.Clients = malloc(sizeof(ListeClients*));
	m.Clients->premier=NULL;
	m.Serveurs = malloc(sizeof(ListeServeurs*));
	m.Serveurs->premier = NULL;
	//m.ip = NULL;
	/*printf("Saisir l'adresse IP:");
	Saisie(m.ip);
	printf("Saisir l'adresse du masque:");
	Saisie(m.mask);*/
	return m;
}
void Color(int couleurDuTexte,int couleurDeFond) // fonction d'affichage de couleurs
{
        HANDLE H=GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(H,couleurDeFond*16+couleurDuTexte);
}
void liste(){
    int i;
    puts("\n");
    printf("Il y a %d machine(s) répertorié(es) dans le parc\n", p.nombre);
	printf("--------------------------------\n");
    	for(i=0;i<p.nombre;i++)
		printf("%s\n", p.machines[i].nom);
}

void Ajout(){
    	p.machines[p.nombre] = SaisieMachine();
    	p.nombre++;
}
void MacAff(AdrMac mac){
	int i;
	for(i=0;i<M;i++){
		printf("%x", mac[i]);
		if(i<M-1)
			printf("-");
	}
}
void AdrAff(AdrIp ip){
	int i;
	for(i=0;i<I;i++){
		printf("%d", ip[i]);
		if(i<I-1)
			printf(".");
	}
}
void MachAff(Machine m){
	Interface(T);
	puts("");
	printf("Nom : %s",m.nom);
	puts("");
	printf("Adresse Mac : "); MacAff(m.mac);
	puts("");
	printf("Connectee: %d",m.connected);
	puts("");
	printf("Adresse IP : "); AdrAff(m.ip);
	puts("");
}
void Recherche(){
	int i=0;
 	char nom2[20];
	printf("Quelle machine voulez-vous afficher\n");
	printf("nom :");
	scanf("%s", nom2);
	while (i<100 && strcmp(nom2, p.machines[i].nom)) i++;
	if(i == 100) puts("Machine introuvable");
	else MachAff(p.machines[i]);
    //Ping(p.ca[i].ip);
}

void GestionParc(){
    Color(15,1);
    int choix,test;
    system("cls");
	do{
        puts("\n");
        puts("------------------------- MENU: Gestion Parc -----------------------");
        puts(" 1) Ajouter une machine dans le parc");
        puts(" 2) Retirer une machine du parc");
        puts(" 3) Afficher une machine");
        puts(" 4) Lister les machines du parc");
        puts(" 5) Rechercher une machine");
        //puts(" 6) Installer un client");
       // puts(" 6) Installer un serveur");
        //puts(" 7) Desinstaller un client");
        //puts(" 8) Desinstaller un serveur");
        puts(" 6) Effacer ecran");
        puts(" 7) Accueil");
        puts("------------------------------------------------------");
        printf("Quel est votre choix: ");
        test = scanf("%d",&choix);

        while(test==0 || choix<1 || choix > 10 ){
            int c;
            while ( ((c = getchar()) != '\n') && c != EOF);
            printf("\a!!!Choix incorrect!!! Retapez: ");
            test = scanf("%d",&choix);
        }
        switch(choix){
            case 1 : Ajout(); break;
            case 3 : Recherche(); break;
            case 4 : liste(); break;
            //case 4 : system("cls"); break;
            case 7: MenuGeneral(); break;
            case 6: system("cls"); break;
        }
	}while(choix!=7 );
}
void GestionReseau(){
    Color(15,4);
    int choix,test;
	//do{
        system("cls");
        puts("\n");
        puts("------------------------- MENU: Gestion Reseau -----------------------");
        puts(" 1) Ajouter une machine dans le reseau");
        puts(" 2) Retirer une machine du reseau");
        puts(" 3) Faire un ping");
        puts(" 4) Afficher le reseau");
        puts(" 5) Accueil");
        puts("------------------------------------------------------");
        printf("Quel est votre choix: ");
        test = scanf("%d",&choix);

        while(test==0 || choix<1 || choix > 5){
            int c;
            while ( ((c = getchar()) != '\n') && c != EOF);
            printf("!!!Choix incorrect!! Retapez: ");
            test = scanf("%d",&choix);
        }
        switch(choix){
            //case 1 : GestionParc(); break;
            //case 2 : Recherche(); break;
            //case 3 : MachSupp(); break;
            //case 4 : system("cls"); break;
            case 5: MenuGeneral(); break;
        }
}
void Simulations(){
    Color(15,2);
    int choix,test;
	//do{
        system("cls");
        puts("\n");
        puts("------------------------- MENU: Simulations -----------------------");
        puts(" 1) ....");
        puts(" 2) ....");
        puts(" 3) ....");
        puts(" 4) Accueil");
        puts("------------------------------------------------------");
        printf("Quel est votre choix: ");
        test = scanf("%d",&choix);

        while(test==0 || choix<1 || choix > 4){
            int c;
            while ( ((c = getchar()) != '\n') && c != EOF);
            printf("!!!Choix incorrect!! Retapez: ");
            test = scanf("%d",&choix);
        }
        switch(choix){
            //case 1 : GestionParc(); break;
            //case 2 : Recherche(); break;
            //case 3 : MachSupp(); break;
            //case 4 : system("cls"); break;
            case 4: MenuGeneral(); break;
        }
}
int MenuGeneral(){
    Color(15,0);
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
        switch(choix){
            case 1 : GestionParc(); break;
            case 2 : GestionReseau(); break;
            case 3 : Simulations(); break;
            case 4 : system("cls"); break;
            case 5: puts("-----------");
                 printf("Bye Bye\n");
                 puts("-----------");
        }
}


int main()
{
    MenuGeneral();
    return 0;
}
