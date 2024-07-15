import React, { useState } from 'react';
import StudentModal from './components/StudentModal';
import StudentList from './components/StudentList';
import './App.css';

const App = () => {
    const [students, setStudents] = useState([
        { id: 1, name: 'Alice', district: '강남', school: '학교 A', major: '수학' },
        { id: 2, name: 'Bob', district: '마포', school: '학교 B', major: '과학' },
        { id: 3, name: 'Charlie', district: '성동', school: '학교 C', major: '영어' },
        { id: 4, name: 'David', district: '동대문', school: '학교 D', major: '미술' },
        { id: 5, name: 'Eve', district: '용산', school: '학교 E', major: '역사' },
    ]);
    const [selectedStudent, setSelectedStudent] = useState(null);
    const [modalVisible, setModalVisible] = useState(false);
    const [filter, setFilter] = useState('');

    const openModal = (student = null) => {
        setSelectedStudent(student);
        setModalVisible(true);
    };

    const closeModal = () => {
        setSelectedStudent(null);
        setModalVisible(false);
    };

    const handleAddOrUpdateStudent = (student) => {
        if (student.id) {
            setStudents(students.map(s => (s.id === student.id ? student : s)));
        } else {
            setStudents([...students, { ...student, id: students.length + 1 }]);
        }
        closeModal();
    };

    const handleDeleteStudent = (id) => {
        setStudents(students.filter(s => s.id !== id));
        closeModal();
    };


    return (
        <div className="app">
            <div className="app-box">
                <h1>학생 관리 시스템</h1>
                <input
                    type="text"
                    placeholder="이름으로 검색..."
                    value={filter}
                    onChange={(e) => setFilter(e.target.value)}
                    onKeyDown={(e) => e.key === 'Enter' && openModal()}
                />
                <StudentList
                    students={students}
                    filter={filter}
                    onSelectStudent={openModal}
                />
                <button onClick={() => openModal()}>추가</button>
                {modalVisible && (
                    <StudentModal
                        student={selectedStudent}
                        onSave={handleAddOrUpdateStudent}
                        onDelete={handleDeleteStudent}
                        onClose={closeModal}
                    />
                )}
            </div>
        </div>
    );
};

export default App;
