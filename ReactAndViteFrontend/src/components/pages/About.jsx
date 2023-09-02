import AboutList from "../Lists/AboutList";

const About = () => {
  const STUDENT_DATA = [
    {
      id: "s1",
      name: "Brian Mgbokwere",
      image: "ReactAndViteFrontend/src/components/photos/Brian.jpg",
      biography:
        "I am a graduate from Northern Illinois University, where I earned my Bachelor of Science in Health Sciences. My studies focused on environmental health, physical and mental health, and how to best deliver care to under-served communities. Despite my background, I have always had an interest in software development.",
    },
    {
      id: "s2",
      name: "Yailin Acosta",
      image: "ReactAndViteFrontend/src/components/photos/Yailin.jpg",
      biography:
        "I have multiple certifications, in the health and food industry, but I have always had on interested in the tech field. Once I started working at Amazon, I decided to study software development."
    },
    {
      id: "s3",
      name: "Steven Lin",
      image: "ReactAndViteFrontend/src/components/photos/Steven.jpg",
      biography:
        "I recently graduated from Pennsylvania State University with Information Science and Technology degree. IST is a very awesome major, we have cybersecurity class, UI/UX design class and a lots of programming class. This is how I start step into the Tech field"
    },
    {
      id: "s4",
      name: "Noah Marsteller",
      image: "ReactAndViteFrontend/src/components/photos/noah.jpg",
      biography:
        "I am a Cincinnati native, and I work at Amazon Air in Wilmington"
    }

  ];

  return (
    <section>
      <h1>Meet The Team</h1>
      <ul>
        <AboutList abouts={STUDENT_DATA} />
      </ul>
    </section>
  );
};

export default About;
