Stratégie de chargement et de cascade – AutoLoc
1. Contrat – Paiement
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Les paiements sont chargés uniquement lorsqu'ils sont nécessaires. Aucune cascade n'est utilisée afin de préserver l'indépendance des paiements et d'éviter leur suppression ou modification automatique lors des opérations effectuées sur le contrat.
 
2. Agence – Véhicule
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Les véhicules sont chargés uniquement lorsqu'ils sont nécessaires. Aucune cascade n'est utilisée, car les véhicules doivent survivre à la suppression d'une agence et peuvent être affectés à une autre agence.

3. Agence – Employé
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Les employés sont chargés uniquement lors de la consultation de la liste des employés. Aucune cascade n'est utilisée, car les employés ont un cycle de vie indépendant de celui de l'agence.

4. Véhicule – Équipement
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Les équipements sont chargés uniquement lorsqu'ils sont nécessaires. Ils peuvent être partagés entre plusieurs véhicules. Aucune cascade n'est donc utilisée afin d'éviter leur suppression accidentelle. Un Set est utilisé pour éviter les doublons.

5. Client – Réservation
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Les réservations sont chargées uniquement lorsqu'elles sont consultées. Aucune cascade n'est utilisée afin de préserver leur indépendance et d'éviter leur suppression automatique avec le client.

6. Réservation – Véhicule
- Fetch : LAZY
- Cascade : Aucune.
- Justification : Le véhicule est chargé uniquement lorsque ses informations sont nécessaires. Aucune cascade n'est utilisée, car le véhicule possède un cycle de vie indépendant de celui de la réservation.

7. Réservation – Contrat
- Fetch : LAZY
- Cascade : PERSIST.
- Justification : Le contrat est chargé uniquement lorsqu'il est nécessaire. La cascade PERSIST permet d'enregistrer automatiquement le contrat lors de l'enregistrement d'une nouvelle réservation, sans propager les autres opérations.

8. Véhicule – Maintenance
- Fetch : LAZY
- Cascade : ALL.
- Justification : Les opérations de maintenance sont chargées uniquement lors de la consultation de l'historique du véhicule. La cascade ALL permet de propager toutes les opérations de persistance à la collection associée, conformément à la consigne du projet.
Conclusion
La stratégie LAZY est utilisée pour éviter les chargements inutiles et améliorer les performances de l'application. Les cascades sont limitées aux associations qui nécessitent une propagation des opérations. Ces choix permettent de préserver l'indépendance des entités et d'éviter les suppressions accidentelles de données.